package com.example;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LongestWordReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        String longestWord = "";

        // Check each token and keep track of the longest one
        for (Text val : values) {
            String current = val.toString();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }
        }

        // Output the single longest word
        context.write(new Text("Longest Word"), new Text(longestWord));
    }
}
