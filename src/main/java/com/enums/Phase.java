package com.enums;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {

	SOLID, LIQUID, GAS;
	
	public enum Transition{
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID); 
		final Phase src;
		final Phase dst;
		
		Transition(Phase src, Phase dst){
			this.src=src;
			this.dst=dst;
		}
		
		private static final Map<Phase, Map<Phase,Transition>> m=new EnumMap<>(Phase.class); 
		
		static{
			for(Phase src:Phase.values())
				m.put(src, new EnumMap<Phase,Transition>(Phase.class));
			for(Transition tran : Transition.values())
				m.get(tran.src).put(tran.dst, tran);
		}
		
		public static Transition from(Phase src , Phase dst){
			return m.get(src).get(dst);
		}
	}
	
}
