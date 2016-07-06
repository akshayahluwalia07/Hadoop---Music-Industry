import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class musicmapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>
{

	
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException
	{
	
    System.out.println(value);
	String[] splits = value.toString().split("[|]");
    for(int i=0;i<splits.length;i++)
    {
    	System.out.println(splits[i]);
    }
    
	IntWritable trackerId = new IntWritable();
	IntWritable userId = new IntWritable();
	
	trackerId.set((Integer.parseInt(splits[1])));
	userId.set((Integer.parseInt(splits[0])));
	context.write(trackerId,userId);
		
	}
	
	
	
}
