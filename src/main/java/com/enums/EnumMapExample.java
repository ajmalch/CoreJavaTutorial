package com.enums;

import com.enums.Phase.Transition;

public class EnumMapExample {

	public static void main(String[] args) {
		
		System.out.println("Transition from Liquid to Solid : " + Transition.from(Phase.LIQUID, Phase.SOLID));
		System.out.println("Transition from Solid to Solid : " + Transition.from(Phase.SOLID, Phase.SOLID));

	}

}
