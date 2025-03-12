package com.example;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LongestWordMapper extends Mapper<LongWritable, Text, Text, Text> {
    // We'll emit all words under one key so the reducer can see them all.
    private static final Text MAP_KEY = new Text("LongestWordCandidate");
    private Text wordOut = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        // Split each line on whitespace
        String[] tokens = value.toString().split("\\s+");

        for (String token : tokens) {
            // Optional: remove punctuation and keep only letters
            token = token.replaceAll("[^a-zA-Z]", "");

            if (!token.isEmpty()) {
                wordOut.set(token);
                // Emit "LongestWordCandidate" as key, and the word as value
                context.write(MAP_KEY, wordOut);
            }
        }
    }
}
