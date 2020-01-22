package com.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


	static class Call {
		int start;
		int end;

		public Call(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static class Employee {
		int id;
		List<Call> calls;
		int breaks;

		public Employee(int id, List<Call> calls) {
			this.id = id;
			this.calls = calls;
			this.breaks = 0;

			if(calls.size() > 1) {
				int count = 0;
				for (int i = 1; i < calls.size(); i++) {

					Call prev = calls.get(i-1);
					Call current = calls.get(i);

					if(current.start != prev.end) {
						count++;
					}
				}

				this.breaks = count;
			}
		}

	} 

	public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {

		Map<Integer, List<Call>> map = new HashMap<>(); 

		for (List<Integer> list : employeeCalls) {
			List<Call> calls = map.getOrDefault(list.get(0), new ArrayList<>());
			calls.add(new Call(list.get(1), list.get(2)));
			map.put(list.get(0), calls);
		}


		List<Employee> employeeList = new ArrayList<>();
		for(Map.Entry<Integer, List<Call>> entry : map.entrySet()) {
			employeeList.add(new Employee(entry.getKey(), entry.getValue()));
		}

		List<List<Integer>> output = new ArrayList<>();

		for (Employee employee : employeeList) {
			if(employee.breaks < k) {
				List<Integer> list = new ArrayList<>();
				list.add(employee.id);
				list.add(employee.breaks);

				output.add(list);
			}
		}
		return output;
	}
}
