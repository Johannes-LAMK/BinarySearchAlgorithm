/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author Johannes
 */
public class Person {

    private String _firstname;
    private String _lastname;
    private int _age;

    public Person(String fname, String lname, int age) {
        this._firstname = fname;
        this._lastname = lname;
        this._age = age;
    }

    /**
     * @return the _firstname
     */
    public String getFirstname() {
        return _firstname;
    }

    /**
     * @return the _lastname
     */
    public String getLastname() {
        return _lastname;
    }

    /**
     * @return the _age
     */
    public int getAge() {
        return _age;
    }

    public static int comparePersons(Person p1, Person p2) {
        // if first person and the second person does not have the same lastname return -1 to sort function
        if (p1.getLastname().compareTo(p2.getLastname()) != 0) {
            return p1.getLastname().compareTo(p2.getLastname());
        }
        // if first person and the second person does not have the same firstname return -1 to sort function
        if (p1.getFirstname().compareTo(p2.getFirstname()) != 0) {
            return p1.getFirstname().compareTo(p2.getFirstname());
        }
        // else return return the substraction of ages
        return p1.getAge() - p2.getAge();
        // this is how we get the array sorted by lname, fname and age
    }
}
