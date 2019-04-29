/*
        * Made By DuckBill
        * Start: 2019.04.09
        * Use_LN: Kotlin
        * Subject: Train Game
*/

package com.example.kotlingame

class LinkedList<T>{
    private var head:Item<T>? = null

    fun isEmpty():Boolean{
        return head == null
    }

    fun first():Item<T>? = head
    fun last(): Item<T>? {
        var node = head
        if (node != null){
            while (node?.next != null) {
                node = node?.next
            }
            return node
        } else {
            return null
        }
    }

    fun count():Int {
        var node = head
        if (node != null){
            var counter = 1
            while (node?.next != null){
                node = node?.next
                counter += 1
            }
            return counter
        } else {
            return 0
        }
    }

    fun nodeAtIndex(index: Int) : Item<T>? {
        if (index >= 0) {
            var node = head
            var i = index
            while (node != null) {
                if (i == 0) return node
                i -= 1
                node = node.next
            }
        }
        return null
    }

    fun append(Name: String, Value: Int, Count: Int) {
        var newNode = Item<T>(Name, Value, Count)

        var lastNode = this.last()
        if (lastNode != null) {
            newNode.previos = lastNode
            lastNode.next = newNode
        } else {
            head = newNode
        }
    }

    fun AllNode():String{
        var node = first()
        var result=""
        if (node != null){
            while (node != null) {
                result = result + node.Name + "," + node.Value + "," + node.Count + "\n"
                node = node.next
            }
        }
        return result
    }

    fun removeAll() {
        head = null
    }

    fun removeNode(node:Item<T>):T?{
        val prev = node.previos
        val next = node.next

        if (prev != null) {
            prev.next = next
        } else {
            head = next
        }
        next?.previos = prev

        node.previos = null
        node.next = null

        return node.index
    }

    fun removeAtIndex(index: Int):T? {
        val node = nodeAtIndex(index)
        if (node != null) {
            return removeNode(node)
        } else {
            return null
        }
    }

    override fun toString(): String {
        var s = "["
        var node = head
        while (node != null) {
            s += "${node.index}"
            node = node.next
            if (node != null) { s += ", " }
        }
        return s + "]"
    }
}