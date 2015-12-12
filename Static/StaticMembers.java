//StaticMembers

public class StaticMembers
{
   public static void main(String[] args)
   {
      Illustrate illusObject1 = new Illustrate(3);
      Illustrate illusObject2 = new Illustrate(5);
      Illustrate.incrementCount();
      Illustrate.y++;
      illusObject1.print();
      illusObject2.print();
   }
}

/*    OUTPUT     from text on p. 39-40

Illustrate illusObject1 = new Illustrate(3);
Illustrate illusObject2 = new Illustrate(5);

Illustrate.increment Count;
illstrrate.y++;

for

illusObject1.print();

result will be:

 x = 3, y = 1. count = 1

 for

 illustObject2.print();

 result will be:

 x = 5, y = 1. count = 1

 */