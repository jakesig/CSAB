public class HuffmanTester {
    public static void main(String[] args) {
        Huffman h = new Huffman();
        h.buildHuffmanTree();
        HuffmanTransmitter runner = new HuffmanTransmitter(h);
        runner.run();
        HuffmanDecoder runner2 = new HuffmanDecoder(runner);
        runner2.run();
    }
}
