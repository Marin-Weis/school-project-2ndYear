# 📘 R3.02 – Efficient Development  
### Practical Work (TP1 to TP4) – Academic Year 2025/2026  
**I.U.T. of Vannes – Computer Science Department – BUT2**

This repository contains all the **practical assignments (TPs)** for the **R3.02 – Data Structures** module, supervised by **J.-F. Kamp**.  
The goal is to apply theoretical concepts through **Java 17** implementations of fundamental data structures (lists, hash tables, collections, binary trees) while respecting **design contracts**, **generics**, and **JUnit4 unit testing**.

---

## 🧩 Repository Content

### **TP1 – Linked List**
Implementation of a **doubly linked list with a sentinel node**.  
Creation of an interface `Liste.java` and a class `ListeChainee.java`.  
Includes **pre/post-conditions**, **invariants**, and an **inner class `Element`**.  
Fully tested with `TestListeChainee.java`.

---

### **TP2 – Hash Table**
Implementation of a simplified **hash table** based on the interface `Table.java`.  
Handles **collisions via circular linear probing**.  
Introduces a **private inner class `Tuple`**.  
Includes **JUnit4 tests** and contract verification.

---

### **TP3 – Bag Class and Generics**
Development of a **generic collection** `Sac<E>` compliant with the Java API (`java.util.Collection`).  
Implements an **inner class `Element`** and an **inner iterator class `Itr`** handling synchronization via a modification counter.  
Explores **generics**, **multiple iterators**, and **compatibility with `AbstractCollection`**.  
Includes comprehensive tests and API behavior validation.

---

### **TP4 – Ordered Binary Tree and Generics**
Design of a **generic binary tree** `ArbreBinaire<E, T>` implementing the interface `Table<E, T>`.  
Implements an **inner class `Noeud`** with algorithms for **insertion, search, deletion, cloning**, and **textual/graphical display**.  
Checks **height**, **balance (AVL)**, and **recursion principles**.  
Unit tested with `TestArbreBinaire.java`.

---

## 🧠 Learning Objectives
- Understand and implement **fundamental data structures**.  
- Apply **contracts, generics, encapsulation, inner classes, and iterators**.  
- Produce **clean, documented (JavaDoc)**, **tested (JUnit4)**, and **Java 17–compliant** code.  
- Develop rigorous skills in the **design → implementation → testing → validation** process.

---

## 📅 Course Timeline

| Week | Topic | Associated TP | Due Date |
|:--:|:--|:--|:--|
| 36 | Course 1 – Overview, tools, grading | — | — |
| 37 | Course 2 – Linked List | TP1 Linked List | 13/09/2025 |
| 38 | Course 3 – Hash Table | TP2 Hash Table | 20/09/2025 |
| 39 | Course 4 – Generics | TP3 Bag Class | 27/09/2025 |
| 40–41 | Courses 5–6 – Tree Structures | TP4 Binary Tree | 11/10/2025 |
