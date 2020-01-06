package binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        BinarySearch ob = new BinarySearch();

        // creating persons
        Person p1 = new Person("Donald", "Duck", 14);
        Person p2 = new Person("Jon", "Doe", 31);
        Person p3 = new Person("Clint", "Eastwood", 111);
        Person p4 = new Person("John", "Bond", 40);
        Person p5 = new Person("John", "Bond", 50);

        // putting persons to list
        Person[] personlist = {p1, p2, p3, p4, p5};
        
        // using Arrays.sort() to sort array and second input parameter to sort by lname, fname, age
        Arrays.sort(personlist, Person::comparePersons);
        
        // put person to search
        Person personToSearch = p5;
        
        System.out.println("Person we are searching: " + personToSearch.getLastname() + " " + personToSearch.getFirstname());
        System.out.println("Array sorted: ");
        
        for (Person p : personlist) {
            System.out.print("[ " + p.getLastname() + " " + p.getFirstname() + " " + p.getAge() + " ] ");
        }
        
        // the range of indexes we are going to look for the person
        int startIndex = 0;
        int endIndex = personlist.length - 1;
        
        // result is the index of the found object. if return is -1 then the object was not found
        int result;
        
        long startBinarySearch = System.currentTimeMillis();
        result = ob.binarySearch(personlist, startIndex, endIndex, personToSearch);
        long endBinarySearch = System.currentTimeMillis(); 
        
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("\n" + personlist[result].getFirstname() + " " + personlist[result].getLastname() + " found at index " + result);
        }
        
        // this is the linear search 
        long startLinearSearch = System.currentTimeMillis();
        System.out.println(personToSearch.getFirstname() + " " + personToSearch.getLastname() + " is found at index: " + linearSearch(personlist, personToSearch));
        long endLinearSearch = System.currentTimeMillis();
        
        System.out.println("Time taken by binary search in ms: " + (endBinarySearch - startBinarySearch));
        System.out.println("Time taken by linear search in ms: " + (endLinearSearch - startLinearSearch));
    }

    // the binary search method
    int binarySearch(Person[] personlist, int startIndex, int endIndex, Person personToLookFor) {
        if (endIndex >= startIndex) {
            
            // mid is the index of the middle object in the range of indexes
            int mid = startIndex + (endIndex - startIndex) / 2;
            
            // if the element is in the  middle, we don't have to look, just return the index
            if (personToLookFor.getLastname().compareTo(personlist[mid].getLastname()) == 0) {
                if (personToLookFor.getFirstname().compareTo(personlist[mid].getFirstname()) == 0) {
                    if (personlist[mid].getAge() == personToLookFor.getAge()) {
                        return mid;
                    }
                }
            }
            // if the the expression is < 0 then it means that the index of a person is on the left of middle
            if (personToLookFor.getLastname().compareTo(personlist[mid].getLastname()) < 0) {
                if(personToLookFor.getFirstname().compareTo(personlist[mid].getFirstname()) < 0) {
                    if(personToLookFor.getAge() != personlist[mid].getAge()) {
                        return binarySearch(personlist, startIndex, mid - 1, personToLookFor);
                    }
                }
            }

            // else it is on the right
            return binarySearch(personlist, mid + 1, endIndex, personToLookFor);
        }

        // if we get here then the person was not found
        return -1;
    }

    //the linear search method
    public static int linearSearch(Person[] arr, Person p) {
        // we just loop trough the array and find it
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getLastname().equals(p.getLastname())) {
                if (arr[i].getFirstname().equals(p.getFirstname())) {
                    if (arr[i].getAge() == p.getAge()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
