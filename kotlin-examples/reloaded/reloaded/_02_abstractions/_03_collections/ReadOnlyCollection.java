package reloaded._02_abstractions._03_collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class ReadOnlyCollection {

    static class Person {
        // Bidirectional
        private final Collection<Person> friends = new HashSet<Person>();

        public void addFriend(Person friend) {
            friends.add(friend);
            friend.friends.add(this);
        }

        // This method is bad!
        public Collection<Person> getFriends() {
            return friends;
        }

        public Collection<Person> getUnmodifiableFriends() {
            return Collections.unmodifiableCollection(friends);
        }

        public Collection<? extends Person> getReadOnlyFriends() {
            return friends;
        }
    }


    public static void main(String[] args) {
        Person john = new Person();
        Person jane = new Person();

        john.getFriends().add(jane);





        Collection<? extends Person> readOnlyFriends = john.getReadOnlyFriends();
        john.getReadOnlyFriends().clear();



        john.getUnmodifiableFriends().add(jane); // exception





//        printAll(john.getFriends());
    }

    static void printAll(Collection<Object> objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }

}
