package com.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {
    public static void main(String[] args) throws Exception {
        // Force Hadoop to use the Windows-friendly temp directory.
        System.setProperty("hadoop.tmp.dir", "C:/temp/hadoop");

        if (args.length != 2) {
            System.err.println("Usage: Driver <input path> <output path>");
            System.exit(-1);
        }

        Configuration conf = new Configuration();
        // Optional: explicitly set local mode if needed.
        // conf.set("fs.defaultFS", "file:///");
        // conf.set("mapreduce.framework.name", "local");

        Job job = Job.getInstance(conf, "Longest Word Job");
        job.setJarByClass(Driver.class);
        job.setMapperClass(LongestWordMapper.class);
        job.setReducerClass(LongestWordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
