package edu.usfca.cs272;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Outputs several simple data structures in "pretty" JSON format where newlines
 * are used to separate elements and nested elements are indented using tabs.
 *
 * Warning: This class is not thread-safe. If multiple threads access this class
 * concurrently, access must be synchronized externally.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Spring 2022
 */
public class SimpleJsonWriter {
	/**
	 * Writes the elements as a pretty JSON array.
	 *
	 * @param elements the elements to write
	 * @param writer the writer to use
	 * @param indent the initial indent level; the first bracket is not indented,
	 *   inner elements are indented by one, and the last bracket is indented at
	 *   the initial indentation level
	 * @throws IOException if an IO error occurs
	 */
	public static void writeArray(
			Collection<Integer> elements, Writer writer, int indent)
			throws IOException {
		// TODO Fill in implementation
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * Writes the elements as a pretty JSON object.
	 *
	 * @param elements the elements to write
	 * @param writer the writer to use
	 * @param indent the initial indent level; the first bracket is not indented,
	 *   inner elements are indented by one, and the last bracket is indented at
	 *   the initial indentation level
	 * @throws IOException if an IO error occurs
	 */
	public static void writeObject(
			Map<String, Integer> elements, Writer writer, int indent)
			throws IOException {
		// TODO Fill in implementation
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * Writes the elements as a pretty JSON object with nested arrays. The generic
	 * notation used allows this method to be used for any type of map with any
	 * type of nested collection of integer objects.
	 *
	 * @param elements the elements to write
	 * @param writer the writer to use
	 * @param indent the initial indent level; the first bracket is not indented,
	 *   inner elements are indented by one, and the last bracket is indented at
	 *   the initial indentation level
	 * @throws IOException if an IO error occurs
	 */
	public static void writeNestedArray(
			Map<String, ? extends Collection<Integer>> elements, Writer writer, int indent)
			throws IOException {
		// TODO Fill in implementation
		throw new UnsupportedOperationException("Not yet implemented.");

		/*
		 * TODO If you choose to use iterators, use the var keyword so you do not
		 * need to explicitly type the iterator:
		 *
		 * var iterator = elements.entrySet().iterator();
		 *
		 * Iterators are not required for this, however. If the syntax is throwing
		 * you off, treat this as if elements had this type:
		 *
		 * TreeMap<String, TreeSet<Integer>> elements --or--
		 * HashMap<String, ArrayList<Integer>> elements
		 *
		 * ...we will cover the meaning of the ? more later!
		 *
		 * (Delete this after reading!)
		 */
	}

	/**
	 * Writes the elements as a pretty JSON array to file.
	 *
	 * @param elements the elements to write
	 * @param path the file path to use
	 * @throws IOException if an IO error occurs
	 *
	 * @see #writeArray(Collection, Writer, int)
	 */
	public static void writeArray(
			Collection<Integer> elements, Path path)
			throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(path, UTF_8)) {
			writeArray(elements, writer, 0);
		}
	}

	/**
	 * Writes the elements as a pretty JSON object to file.
	 *
	 * @param elements the elements to write
	 * @param path the file path to use
	 * @throws IOException if an IO error occurs
	 *
	 * @see #writeObject(Map, Writer, int)
	 */
	public static void writeObject(
			Map<String, Integer> elements, Path path)
			throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(path, UTF_8)) {
			writeObject(elements, writer, 0);
		}
	}

	/**
	 * Writes the elements as a pretty JSON object with nested arrays to file.
	 *
	 * @param elements the elements to write
	 * @param path the file path to use
	 * @throws IOException if an IO error occurs
	 *
	 * @see #writeNestedArray(Map, Writer, int)
	 */
	public static void writeNestedArray(
			Map<String, ? extends Collection<Integer>> elements, Path path)
			throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(path, UTF_8)) {
			writeNestedArray(elements, writer, 0);
		}
	}

	/**
	 * Returns the elements as a pretty JSON array.
	 *
	 * @param elements the elements to use
	 * @return a {@link String} containing the elements in pretty JSON format
	 *
	 * @see #writeArray(Collection, Writer, int)
	 */
	public static String writeArray(Collection<Integer> elements) {
		try {
			StringWriter writer = new StringWriter();
			writeArray(elements, writer, 0);
			return writer.toString();
		}
		catch (IOException e) {
			return null;
		}
	}

	/**
	 * Returns the elements as a pretty JSON object.
	 *
	 * @param elements the elements to use
	 * @return a {@link String} containing the elements in pretty JSON format
	 *
	 * @see #writeObject(Map, Writer, int)
	 */
	public static String writeObject(Map<String, Integer> elements) {
		try {
			StringWriter writer = new StringWriter();
			writeObject(elements, writer, 0);
			return writer.toString();
		}
		catch (IOException e) {
			return null;
		}
	}

	/**
	 * Returns the elements as a pretty JSON object with nested arrays.
	 *
	 * @param elements the elements to use
	 * @return a {@link String} containing the elements in pretty JSON format
	 *
	 * @see #writeNestedArray(Map, Writer, int)
	 */
	public static String writeNestedArray(Map<String, ? extends Collection<Integer>> elements) {
		try {
			StringWriter writer = new StringWriter();
			writeNestedArray(elements, writer, 0);
			return writer.toString();
		}
		catch (IOException e) {
			return null;
		}
	}

	/*
	 * TODO The following methods for adding indentation and quotes are provided
	 * for you, but you do not need to use them if you do not want.
	 *
	 * (Delete this after reading!)
	 */

	/**
	 * Indents the writer by the specified number of times. Does nothing if the
	 * indentation level is 0 or less.
	 *
	 * @param writer the writer to use
	 * @param indent the number of times to indent
	 * @throws IOException if an IO error occurs
	 */
	public static void writeIndent(Writer writer, int indent) throws IOException {
		while (indent-- > 0) {
			writer.write('\t');
		}
	}

	/**
	 * Indents and then writes the String element.
	 *
	 * @param element the element to write
	 * @param writer the writer to use
	 * @param indent the number of times to indent
	 * @throws IOException if an IO error occurs
	 */
	public static void writeIndent(String element, Writer writer, int indent) throws IOException {
		writeIndent(writer, indent);
		writer.write(element);
	}

	/**
	 * Indents and then writes the text element surrounded by {@code " "}
	 * quotation marks.
	 *
	 * @param element the element to write
	 * @param writer the writer to use
	 * @param indent the number of times to indent
	 * @throws IOException if an IO error occurs
	 */
	public static void writeQuote(String element, Writer writer, int indent) throws IOException {
		writeIndent(writer, indent);
		writer.write('"');
		writer.write(element);
		writer.write('"');
	}

	/**
	 * Demonstrates this class.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		Set<Integer> empty = Collections.emptySet();
		Set<Integer> single = Set.of(42);
		List<Integer> simple = List.of(65, 66, 67);

		System.out.println("\nArrays:");
		System.out.println(writeArray(empty));
		System.out.println(writeArray(single));
		System.out.println(writeArray(simple));

		System.out.println("\nObjects:");
		System.out.println(writeObject(Collections.emptyMap()));
		System.out.println(writeObject(Map.of("hello", 42)));
		System.out.println(writeObject(Map.of("hello", 42, "world", 67)));

		System.out.println("\nNested Arrays:");
		System.out.println(writeNestedArray(Collections.emptyMap()));
		System.out.println(writeNestedArray(Map.of("hello", single)));
		System.out.println(writeNestedArray(Map.of("hello", single, "world", simple)));
	}
}
