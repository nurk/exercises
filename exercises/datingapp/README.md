# Remote pair exercise
## Exercise
### Situation
It is almost Valentine's day. 
To make sure everybody finds their true love we created a dating application.

But their are still some essential features missing that you have to implement.

### Stories
1. Right now you are matched with a random person, make sure you can put in some preferences about age, sex and personality in a new screen.
2. We can match with other users, but we can't message them yet. Implement some functionality to send messages to users we matched with. They don't have to reply back.
3. Add functionality to block users after we matched with them.

## How does it work?
### Application
The project contains a simple console application, just run the main method and input numbers to go through the different screens.

### Dependency Injection
Guice is used as a simple dependency injection library. Guice will automatically inject your members if you put an @Inject at the constructors.  
Just make sure the members you inject have no constructor or an @Inject at theirs as well.  
If you want to do some more complicated stuff like injecting a derived class when you put its interface in the members, take a look at https://github.com/google/guice/wiki/GettingStarted.

### Views
If you want to add your view in the application make sure it implements the View interface.
Returning another viewclass in your run method will switch to that view afterwards. Likewise you can return your viewclass in e.g. the MainView so you can switch to it from there.

### IOFacade and RandomFacade
These facades are created so it is easy to mock them out in the tests. You can find some examples of tests in the code.
Just make sure to use IOFacade::output instead of System.out.println()
