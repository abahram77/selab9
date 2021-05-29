/*
 * $Id: Test.java,v 1.1 2006/04/15 14:40:06 platform Exp $
 * Created on 2006-4-15
 */
package org.json.simple;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class TestJson {

    @Test
    public void testDecode() throws Exception {
        System.out.println("=======decode=======");

        String s = "[0,10]";
        Object obj = JSONValue.parse(s);
        JSONArray array = (JSONArray) obj;
        System.out.println("======the 2nd element of array======");
        System.out.println(array.get(1));
        System.out.println();
        assertEquals("10", array.get(1).toString());
    }

    @Test
    public void testJSONArrayCollection() {
        final ArrayList<String> testList = new ArrayList<String>();
        testList.add("First item");
        testList.add("Second item");
        final JSONArray jsonArray = new JSONArray(testList);

        assertEquals("[\"First item\",\"Second item\"]", jsonArray.toJSONString());
    }

    @Test
    public void testWriteJSONString() {
        Writer writer1 = new StringWriter();
        Writer writer2 = new StringWriter();
        Writer writer3 = new StringWriter();
        Writer writer4 = new StringWriter();
        Writer writer5 = new StringWriter();
        Writer writer6 = new StringWriter();
        Writer writer7 = new StringWriter();
        Writer writer9 = new StringWriter();
        Writer writer8 = new StringWriter();

        try {
            byte[] arr1 = new byte[]{1, 2, 3, 4, 5, 6, 7};
            JSONArray.writeJSONString(arr1, writer1);
            assertEquals("[1,2,3,4,5,6,7]", writer1.toString());

            short[] arr2 = new short[]{1, 2, 3, 4, 5, 6, 7};
            JSONArray.writeJSONString(arr2, writer2);
            assertEquals("[1,2,3,4,5,6,7]", writer2.toString());

            int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7};
            JSONArray.writeJSONString(arr3, writer3);
            assertEquals("[1,2,3,4,5,6,7]", writer3.toString());

            long[] arr4 = new long[]{1, 2, 3, 4, 5, 6, 7};
            JSONArray.writeJSONString(arr4, writer4);
            assertEquals("[1,2,3,4,5,6,7]", writer4.toString());

            float[] arr5 = new float[]{1.0f, 2.0f, 3.0f, 4.0f};
            JSONArray.writeJSONString(arr5, writer5);
            assertEquals("[1.0,2.0,3.0,4.0]", writer5.toString());

            double[] arr6 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
            JSONArray.writeJSONString(arr6, writer6);
            assertEquals("[1.0,2.0,3.0,4.0,5.0]", writer6.toString());

            boolean[] arr7 = new boolean[]{true, false, true, false};
            JSONArray.writeJSONString(arr7, writer7);
            assertEquals("[true,false,true,false]", writer7.toString());

            char[] arr8 = new char[]{'A', 'B', 'C', 'D'};
            JSONArray.writeJSONString(arr8, writer8);
            assertEquals("[\"A\",\"B\",\"C\",\"D\"]", writer8.toString());

            Object[] arr9 = new Object[]{new Stack<>().push(1)};
            JSONArray.writeJSONString(arr9, writer9);
            assertEquals("[1]", writer9.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToJsonString() {
        byte[] arr1 = new byte[]{1, 2, 3, 4, 5, 6, 7};
        String res1 = JSONArray.toJSONString(arr1);
        assertEquals("[1,2,3,4,5,6,7]", res1);

        short[] arr2 = new short[]{1, 2, 3, 4, 5, 6, 7};
        String res2 = JSONArray.toJSONString(arr2);
        assertEquals("[1,2,3,4,5,6,7]", res2);

        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        String res3 = JSONArray.toJSONString(arr3);
        assertEquals("[1,2,3,4,5,6,7]", res3);

        long[] arr4 = new long[]{1, 2, 3, 4, 5, 6, 7};
        String res4 = JSONArray.toJSONString(arr4);
        assertEquals("[1,2,3,4,5,6,7]", res4);

        float[] arr5 = new float[]{1.0f, 2.0f, 3.0f, 4.0f};
        String res5 = JSONArray.toJSONString(arr5);
        assertEquals("[1.0,2.0,3.0,4.0]", res5);

        double[] arr6 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        String res6 = JSONArray.toJSONString(arr6);
        assertEquals("[1.0,2.0,3.0,4.0,5.0]", res6);

        boolean[] arr7 = new boolean[]{true, false, true, false};
        String res7 = JSONArray.toJSONString(arr7);
        assertEquals("[true,false,true,false]", res7);

        char[] arr8 = new char[]{'A', 'B', 'C', 'D'};
        String res8 = JSONArray.toJSONString(arr8);
        assertEquals("[\"A\",\"B\",\"C\",\"D\"]", res8);

        Object[] arr9 = new Object[]{new Stack<>().push(1)};
        String res9 = JSONArray.toJSONString(arr9);
        assertEquals("[1]", res9);
    }


    @Test
    public void testToString() {
        Stack<Integer> stack = new Stack<>();
        stack.push(99);
        JSONArray jsonArray = new JSONArray(stack);
        assertEquals("[99]", jsonArray.toString());
    }

    @Test
    public void testNullValue() {
        Writer writer1 = new StringWriter();
        Writer writer2 = new StringWriter();
        Writer writer3 = new StringWriter();
        Writer writer4 = new StringWriter();
        Writer writer5 = new StringWriter();
        Writer writer6 = new StringWriter();
        Writer writer7 = new StringWriter();
        Writer writer9 = new StringWriter();
        Writer writer8 = new StringWriter();

        try {
            JSONArray.writeJSONString((byte[]) null, writer1);
            assertEquals("null", writer1.toString());

            JSONArray.writeJSONString((short[]) null, writer2);
            assertEquals("null", writer2.toString());

            JSONArray.writeJSONString((int[]) null, writer3);
            assertEquals("null", writer3.toString());

            JSONArray.writeJSONString((long[]) null, writer4);
            assertEquals("null", writer4.toString());

            JSONArray.writeJSONString((float[]) null, writer5);
            assertEquals("null", writer5.toString());

            JSONArray.writeJSONString((double[]) null, writer6);
            assertEquals("null", writer6.toString());

            JSONArray.writeJSONString((boolean[]) null, writer7);
            assertEquals("null", writer7.toString());

            JSONArray.writeJSONString((char[]) null, writer8);
            assertEquals("null", writer8.toString());

            JSONArray.writeJSONString((Object[]) null, writer9);
            assertEquals("null", writer9.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testZeroLength() {
        Writer writer1 = new StringWriter();
        Writer writer2 = new StringWriter();
        Writer writer3 = new StringWriter();
        Writer writer4 = new StringWriter();
        Writer writer5 = new StringWriter();
        Writer writer6 = new StringWriter();
        Writer writer7 = new StringWriter();
        Writer writer9 = new StringWriter();
        Writer writer8 = new StringWriter();

        try {
            JSONArray.writeJSONString(new byte[]{}, writer1);
            assertEquals("[]", writer1.toString());

            JSONArray.writeJSONString(new short[]{}, writer2);
            assertEquals("[]", writer2.toString());

            JSONArray.writeJSONString(new int[]{}, writer3);
            assertEquals("[]", writer3.toString());

            JSONArray.writeJSONString(new long[]{}, writer4);
            assertEquals("[]", writer4.toString());

            JSONArray.writeJSONString(new float[]{}, writer5);
            assertEquals("[]", writer5.toString());

            JSONArray.writeJSONString(new double[]{}, writer6);
            assertEquals("[]", writer6.toString());

            JSONArray.writeJSONString(new boolean[]{}, writer7);
            assertEquals("[]", writer7.toString());

            JSONArray.writeJSONString(new char[]{}, writer8);
            assertEquals("[]", writer8.toString());

            JSONArray.writeJSONString(new Object[]{}, writer9);
            assertEquals("[]", writer9.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonObject() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ten", 10);
        String actual = JSONObject.toJSONString(map);
        assertEquals("{\"ten\":10}", actual);
    }


    @Test
    public void testJsonValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ten", 10);
        String actual = JSONValue.toJSONString(map);
        assertEquals("{\"ten\":10}", actual);
    }

    @Test
    public void testJsonParser() {
        JSONParser jsonParser = new JSONParser();
        try {
            HashMap<String, List<Long>> actual = (HashMap<String, List<Long>>) jsonParser.parse("{\"key\":[1,2]}");
            HashMap<String, List<Long>> expected = new HashMap<>();
            List<Long> list = new ArrayList<>();
            list.add(1L);
            list.add(2L);
            expected.put("key", list);
            assertEquals(expected.get("key").get(0), actual.get("key").get(0));
            assertEquals(expected.get("key").get(1), actual.get("key").get(1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseException() {
        ParseException parseException = new ParseException(1);
        assertEquals("Unexpected token null at position -1.", parseException.getMessage());
    }
}
