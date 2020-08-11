package covid.service;

import java.util.ArrayList;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public interface CovidOperation {
		public void addVisitor(Visitor v);
		public ArrayList<Visitor> getAllVisitors();
		public void deleteVistor(String name);
		public boolean checkMask(String name);
		public ArrayList<Visitor> overTemperature(double temperature);
		public Visitor updateCondition(String name, Fever fever);
		public Visitor updateCondition(String name, String symptom);
}
