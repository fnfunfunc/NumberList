package com.eternal.numberlist.ui.utils

import com.eternal.numberlist.ui.page.NumberItem

/**
 * Binary insert for ordered list
 * @warning Can only be used when the list is ordered
 * @return Return a Boolean value indicating whether the insertion was successful
 * I hope that Kotlin can provide a grammar which I can use the upper bound of generic with operator +(The way like Rust)
 */
fun MutableList<NumberItem>.insert(num: NumberItem) {
    if(this.isEmpty()) {
        this.add(num)
        return
    }
    var left = 0
    var right = this.size - 1
    while(left <= right){
        val mid = (left + right) shr 1;
        if(this[mid].number < num.number) {
            left = mid + 1
        } else if (this[mid].number > num.number) {
            right = mid - 1
        } else {
            this.add(index = mid, element = num)
            return
        }
    }
    this.add(index = left, element = num)
}