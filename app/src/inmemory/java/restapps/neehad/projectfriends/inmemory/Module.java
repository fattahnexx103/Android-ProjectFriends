package restapps.neehad.projectfriends.inmemory;


import infrastructure.Appl;

public class Module {

    public static void Register(Appl application){
        new InMemoryFriendService(application);
        new InMemoryCardsService(application);
        new InMemoryPicture(application);
    }
}
