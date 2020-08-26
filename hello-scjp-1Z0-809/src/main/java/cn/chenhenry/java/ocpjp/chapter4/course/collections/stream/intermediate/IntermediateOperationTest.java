package cn.chenhenry.java.ocpjp.chapter4.course.collections.stream.intermediate;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Data
@AllArgsConstructor
class Node {
    private int val;
}


public class IntermediateOperationTest {
    public static void main(String[] args) {
        List<Integer> result = Stream.of(1, 2, 3, 4, 5)
                .peek(i -> System.out.println("first peek: " + i))
                .map(i -> i * i)
                .peek(i -> System.out.println("second peek: " + i))
                .collect(Collectors.toList());
        System.out.println(result);

        List<Node> nodes = Stream.of(1, 2, 3, 4, 5)
                .map(Node::new)
                .peek(i -> System.out.println("first peek: " + i))
                .peek(node -> node.setVal(node.getVal() * node.getVal()))
                .peek(i -> System.out.println("second peek: " + i))
                .collect(Collectors.toList());
        System.out.println(nodes);

    }
}
