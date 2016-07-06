import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class musicreducer extends 
Reducer<IntWritable, IntWritable, IntWritable,IntWritable>

{
	@Override
	public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
	throws IOException, InterruptedException
	{
		Set<Integer> hashset = new HashSet<Integer>();
		for(IntWritable value: values)
		{
			
			hashset.add(value.get());
		}
		IntWritable size=  new IntWritable(hashset.size());
		context.write(key,size);
	}

}
