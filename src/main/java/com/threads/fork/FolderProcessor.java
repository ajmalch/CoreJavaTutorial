package com.threads.fork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4905290370431917938L;

	private final String path;
	private final String extension;
	
	public FolderProcessor(String path, String extension) {
		this.path=path;
		this.extension=extension;
	}
	
	@Override
	protected List<String> compute() {
		List<String> list= new ArrayList<>();
		List<FolderProcessor> tasks= new ArrayList<>();
		
		File file= new File(path);
		File content[]=file.listFiles();
		if(content!=null){
			for(File f:content ){
				if(f.isDirectory()){
					FolderProcessor task= new FolderProcessor(f.getAbsolutePath(), extension);
					task.fork();
					tasks.add(task);
				}
				else {
					if(checkFile(f.getName()))
						list.add(f.getAbsolutePath());
				}
			}
		}
		
		addResultsFromTasks(list, tasks);
		System.out.println("******************\n\n\n");
		return list;
	}

	private boolean checkFile(String name){
		return name.endsWith(extension);
	}
	
	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks){
		for(FolderProcessor item : tasks){
			list.addAll(item.join());
//			System.out.println(item.join());
		}
	}
}
