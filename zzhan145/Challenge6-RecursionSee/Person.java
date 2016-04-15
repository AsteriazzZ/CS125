//UIUC CS125 SPRING 2016 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:12:33-0500.368833636
/**
 * @author zzhan145
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name + "*" + age + "*" + gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age == p.age) &&
			(this.gender == p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
}

public int count() // total person count including this object
{
	//YOUR CODE HERE
	int n = 1;
	
	if (child1 != null)
		n += child1.count();
	if (child2 != null)
		n += child2.count();
	
	return n;
	
}
public int countGrandChildren() // but not greatGrandChildren
{
	//YOUR CODE HERE
	int n = 0;
	
	if(child1!=null){
		if(child1.child1 != null)
			n++;
		if(child1.child2 != null)
			n++;
	}
	if(child2!=null){
		if(child2.child1 != null)
			n++;
		if(child2.child2 != null)
			n++;
	}
	return n;
	
}

public int countMaxGenerations()
{
	//YOUR CODE HERE
	int m1 = 0; int m2 = 0;
	
	if (this.child1 != null)
		m1 = child1.countMaxGenerations();
	if (this.child2 != null)
		m2 = child2.countMaxGenerations();
	
	if (m1 > m2)
		return 1 + m1;
	return 1 + m2;
	
}

public int countGender(char gen)
{
	//YOUR CODE HERE
	int g = 0;
	
	if (this.gender == gen) 
		g = g + 1;
	
	if (child1 != null)
		g += child1.countGender(gen);
	if (child2 != null)
		g += child2.countGender(gen);
	
	return g;
}


public Person search(String name, int maxGeneration)
{
	//YOUR CODE HERE
	if (this.getName().equals(name)) 
		return this;
	if(maxGeneration == 0)
		return null;
	if(this.child1 == null && this.child2 == null)
		return null;
	
	if(this.child1 == null && this.child2 != null)
		return child2.search(name, maxGeneration - 1);
	if(this.child1 != null && this.child2 == null)
		return child1.search(name, maxGeneration - 1);
	
	if(child1.search(name, maxGeneration - 1) == null)
		return child2.search(name, maxGeneration - 1);
	return child1.search(name, maxGeneration - 1);
	
}

} // end of class
