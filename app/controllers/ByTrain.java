package controllers;

import models.*;

public class ByTrain implements StrategyPlanner{

	@Override
	public String fromTo(Country conA, City cityA, Country conB, City cityB) {
		// TODO Auto-generated method stub

		return "Move from " + cityA.getName() + ", " + conA.getName() + " to " + cityB.getName() + ", " + conB.getName() + " by Train\n";
	}

}
