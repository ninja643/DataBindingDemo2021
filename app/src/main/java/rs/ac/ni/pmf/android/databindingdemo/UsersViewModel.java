package rs.ac.ni.pmf.android.databindingdemo;

import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class UsersViewModel extends ViewModel
{
	private int current;

	private List<User> users = Arrays.asList(
			new User("Petar", "Petrovic", 24),
			new User("Mika", "Petrovic", 14),
			new User("Tasa", "Petrovic", 34),
			new User("Zika", "Petrovic", 25)
	);

	public User getCurrentUser()
	{
		return users.get(current);
	}

	public boolean hasNext()
	{
		return current < users.size() - 1;
	}

	public boolean hasPrevious()
	{
		return current > 0;
	}

	public User getNextUser()
	{
		if (hasNext())
		{
			current++;
		}

		return getCurrentUser();
	}

	public User getPreviousUser()
	{
		if (hasPrevious())
		{
			current--;
		}

		return getCurrentUser();
	}
}
