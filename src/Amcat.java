import java.util.ArrayList;
import java.util.List;

public class Amcat {

	public List<Integer> cellCompete(int[] states, int days)
	{
		int[] newStates = new int[states.length];   
		for(int i = 0; i < days; i++) {
			newStates = cellCompete(states);
			System.arraycopy(newStates, 0, states, 0, newStates.length);
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < newStates.length; i++) {
			list.add(newStates[i]);
		}

		return list;
	}

	public int[] cellCompete(int[] states) {
		int[] newStates = new int[states.length];

		for (int i = 0; i < states.length ; i++) {
			int prev = 0;
			int next = 0;
			if(i == 0) {
				next = states[i+1];
			} else if(i == states.length-1) {
				prev = states[i-1];
			} else {
				prev = states[i-1];
				next = states[i+1];
			}

			newStates[i] = prev ^ next;
		}
		return newStates;
	}

}
