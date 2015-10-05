# functional-programming-scala

This repo contains examples written in functional programming style. Programs can be written in this style in any 
language. This repo uses scala as its languge.
 
 
1. [BasicLoop](src/main/scala/examples/BasicLoop.scala): A basic 'for' loop has mutable state. This example shows how do do a basic loop in a functional 
   way so as to avoid any mutable state. 
   
2. [FoldLeft](src/main/scala/examples/FoldLeft.scala): This is a very versatile method. I put together some examples using foldLeft in here to show case its 
   versatility. Comes in very handy when you have a loop in mind.

3. [SortingAlgorithms](src/main/scala/examples/SortingAlgorithms.scala): Some sorting algorithms written in functional style. These are usually written with nested loops 
   in imperative style but are now written in a functional way.  
  * InsertionSort
  * QuickSort
  * BubbleSort
  * MergeSort
  * SelectionSort
  
##Type Classes
 
Scala has 'type classes' that supports ad-hoc polymorphism. I am not sure about the relevance of this feature to scala supporting functional programming but it looks like its a pretty widely used one. 
Here is an example of a type class pattern using context bounds.

They really help with decoupling / separation of concerns.

[Type Class Example](src/main/scala/examples/typeclass)

In this example, if not for the Json type class, JsonWriter(present in JsonValue.scala) would need a direct/indirect dependency on Expression for it to be able to convert an Expression to a Json string representation. 