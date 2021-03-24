package rs.ac.ni.pmf.android.databindingdemo;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import rs.ac.ni.pmf.android.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
	private User user = new User("Petar", "Petrovic", 24);
	private int current;

	private List<User> users = Arrays.asList(
			new User("Petar", "Petrovic", 24),
			new User("Mika", "Petrovic", 14),
			new User("Tasa", "Petrovic", 34),
			new User("Zika", "Petrovic", 25)
	);

	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		binding.setUser(users.get(current));
	}

	public void nextUser(View view)
	{
		if (current < users.size() - 1)
		{
			current++;
			binding.setUser(users.get(current));
		}
	}

	public void previousUser(View view)
	{
		if (current > 0)
		{
			current--;
			binding.setUser(users.get(current));
		}
	}
}