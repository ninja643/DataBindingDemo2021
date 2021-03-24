package rs.ac.ni.pmf.android.databindingdemo;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable
{
	private String firstName;
	private String lastName;
	private int age;
	private boolean registered;

	public User(final String firstName, final String lastName, final int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
//		this.age.set(age);
	}

	@Bindable
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
		notifyPropertyChanged(BR.firstName);
	}

	@Bindable
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
		notifyPropertyChanged(BR.lastName);
	}

	@Bindable
	public int getAge()
	{
		return age;
	}

	public void getOlder(int amount)
	{
//		age.set(age.get() + amount);
		age += amount;
		notifyPropertyChanged(BR.age);

		firstName += firstName.charAt(0);
		notifyPropertyChanged(BR.firstName);

		Log.i("DATA_BINDING", "Current age: " + age);
	}

	@Bindable
	public boolean isRegistered()
	{
		return registered;
	}

	public void setRegistered(final boolean registered)
	{
		this.registered = registered;
		notifyPropertyChanged(BR.registered);
		Log.i("DATA_BINDING", "User registered: " + registered);
	}
}
