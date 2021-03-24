package rs.ac.ni.pmf.android.databindingdemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import rs.ac.ni.pmf.android.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
	private ActivityMainBinding binding;
	private UsersViewModel usersViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		binding.setUser(usersViewModel.getCurrentUser());
	}

	public void nextUser(View view)
	{
		if (usersViewModel.hasNext())
		{
			binding.setUser(usersViewModel.getNextUser());
		}
	}

	public void previousUser(View view)
	{
		if (usersViewModel.hasPrevious())
		{
			binding.setUser(usersViewModel.getPreviousUser());
		}
	}
}