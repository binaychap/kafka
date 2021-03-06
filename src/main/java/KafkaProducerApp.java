import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by binayrai on 3/18/17.
 */
public class KafkaProducerApp {


    public static void main(String[] args){

        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092,localhost:9093");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> myProducer = new KafkaProducer<String, String>(props);

        try{
            for(int i = 0; i < 150; i++){
                myProducer.send(new ProducerRecord<String, String>("my-topic",Integer.toString(i),"MyMessage:"+Integer.toString(i)));

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            myProducer.close();
        }
    }

}
