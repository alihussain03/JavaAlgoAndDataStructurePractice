# DSA Concepts List

## Arrays

- Basics
- **Two Pointers**
- Sliding Window

## Stack

Stack is a linear data structure that operates on the principle of Last-In, First-Out (LIFO),
meaning the most recently added element is the first one to be removed.

- Operations:
    - **Push**: Add an element to the top of the stack 0(1)
    - **Pop**: Remove an element from the top of the stack 0(1)
    - **Peek**: Get the top element of the stack 0(1)
    - **isEmpty**: Check if the stack is empty 0(1)
    - **isFull**: Check if the stack is full 0(1)
    - **Size**: Get the number of elements in the stack 0(1)
    - **Search**: Search for an element in the stack 0(n)
    - **Clear**: Remove all elements from the stack 0(n)
- Implementing Stack using:
    - **Array**
    - **Linked List**
- Applications:
    - Memory management
    - Expression evaluation
    - Function calls
    - Undo mechanisms
    - Backtracking
    - Depth First Search (DFS)
    - web pages history in browsers

## Queue

Queue is a linear data structure that operates on the principle of First-In, First-Out (FIFO),meaning the earliest
added element is the first one to be removed.

- Types
    - **Simple queue**
    - **Deque (Double ended queue)**: elements can be added or removed from both ends of the Queue. Think about a
      library line where you can borrow books from one end and return books at the other end.
    - **Circular queue**: A circular queue is a linear data structure where the last position is connected back to the
      first, forming a circle. It efficiently utilizes space by reusing positions when elements are dequeued.
    - **Priority queue**: A priority queue is a data structure where each element has a priority, and elements with
      higher priority are dequeued before elements with lower priority. It can be implemented using heaps for efficient
      access to the highest (or lowest) priority element.
    - **Affinity queue**: every element has an affinity & is placed with an element having the same affinity; otherwise
      placed at the rear
- Operations:
    - **Enqueue:** 0(1)
    - **Dequeue:** 0(1)
    - **Front:** 0(1)
    - **isEmpty:** 0(1)
- Implementing Stack using:
    - **Array**
    - **Linked List**
    - **Two stack**
- Applications:
    - CPU scheduling
    - Task scheduling
    - Breadth first search
    - Messaging Systems – Used in asynchronous communication (e.g., Kafka, RabbitMQ, message queues)
    - Caching
    - Printers
    - Call center