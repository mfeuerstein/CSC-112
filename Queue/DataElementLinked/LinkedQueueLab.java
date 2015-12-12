
public class Ch7_PrExercise2
{
    public static void main(String[] args)
    {
        LinkedQueueClass queue1 = new LinkedQueueClass();
        LinkedQueueClass queue2 = new LinkedQueueClass();

        queue1.addQueue(new IntElement(23));
        queue1.addQueue(new IntElement(45));
        queue1.addQueue(new IntElement(38));

        queue2.copyQueue(queue1);

        LinkedQueueClass queue3 = new LinkedQueueClass(queue1);

        queue1.addQueue(new IntElement(88));

        System.out.print("queue1: ");

        while(!queue1.isEmptyQueue())
        {
            System.out.print(queue1.front() + " ");
            queue1.deleteQueue();
        }

        System.out.println();

        System.out.print("queue2: ");

        while(!queue2.isEmptyQueue())
        {
            System.out.print(queue2.front() + " ");
            queue2.deleteQueue();
        }

        System.out.println();

        System.out.print("queue3: ");

        while(!queue3.isEmptyQueue())
        {
            System.out.print(queue3.front() + " ");
            queue3.deleteQueue();
        }

        System.out.println();
    }
}

