//package trie
//
//import java.io.File
//import java.util.*
//
//val allNodes = mutableListOf<TrieNode>()
//
//data class TrieNode(
//    val parent: TrieNode?,
//    val index: Int,
//    val arr: Array<TrieNode?> = arrayOfNulls(26),
//    var count: Int = 0
//) {
//
//    init {
//        allNodes.add(this)
//    }
//
//    fun getWord(): String {
//        return if (this.index >= 0) {
//            this.parent!!.getWord() + (this.index + 97).toChar()
//        } else {
//            "";
//        }
//    }
//}
//
//class Trie {
//    private val root: TrieNode = TrieNode(null, -1)
//
//    // Inserts a word into the trie.
//    fun insert(word: String) {
//        var p: TrieNode? = root
//        for (element in word) {
//            val c = element
//            val index = c.toInt() - 'a'.toInt()
//            if (index > 26) {
//                throw RuntimeException("Oh shit")
//            }
//            if (p!!.arr[index] == null) {
//                val temp = TrieNode(p, index)
//                p.arr[index] = temp
//                p = temp
//            } else {
//                p = p.arr[index]
//            }
//        }
//        p!!.count++
//    }
//
//
//    // Returns if the word is in the trie.
//    fun search(word: String): Int {
//        val p = searchNode(word)
//        return p?.count ?: 0
//    }
//
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    fun startsWith(prefix: String): Boolean {
//        val p = searchNode(prefix)
//        return p != null
//    }
//
//    fun searchNode(s: String): TrieNode? {
//        var p: TrieNode? = root
//        for (i in 0 until s.length) {
//            val c = s[i]
//            val index = c - 'a'
//            p = if (p!!.arr[index] != null) {
//                p.arr[index]
//            } else {
//                return null
//            }
//        }
//        return if (p === root) null else p
//    }
//
//}
//
//fun main() {
//    val start = System.currentTimeMillis()
//
//    val trie = Trie()
//
//    val regex = Regex("[a-z]+", RegexOption.IGNORE_CASE)
//
//    val file = File("/Users/sellarsd/workspace/id/katas/ulysses64")
//
////    file.useLines(charset = Charsets.US_ASCII) {
////        it.iterator()
////            .forEach { line ->
////                regex.findAll(line).iterator().forEach { word ->
////                    trie.insert(word.value.toLowerCase(Locale.US))
////                }
////            }
////    }
//
//        val bufferedReader = file.bufferedReader(charset = Charsets.US_ASCII)
//        for (line in bufferedReader.lines()) {
//            for (word in regex.findAll(line)) {
//                trie.insert(word.value.toLowerCase())
//            }
//        }
//
//    allNodes.sortedWith(compareByDescending { it.count })
//        .take(10)
//        .forEach { println("${it.getWord()} - ${it.count}") }
//
//    val end = System.currentTimeMillis()
//
//    println("Run time: ${end - start}ms")
//}