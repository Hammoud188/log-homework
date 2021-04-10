package pkg;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final Marker FIRST_MARKER = MarkerManager.getMarker("GOOD_NIGHT");
    private static final Marker SECOND_MARKER = MarkerManager.getMarker("WONDER");
    private static final Marker THIRD_MARKER = MarkerManager.getMarker("PILLOW");


    public static void main(String[] args) {

            String song  = """
                        One, two, three, four, five,
                        Once I caught a fish alive,
                       Six, seven, eight, nine, ten,
                       Then I let go again.         
                    """;

            for(int i=0; i< Integer.parseInt(args[0]); i++){
                ThreadContext.push(String.valueOf(i));


                logger.debug(FIRST_MARKER,"One, two, three, four, five,");
                logger.fatal(SECOND_MARKER, "Once I caught a fish alive,");
                logger.warn(THIRD_MARKER, "Six, seven, eight, nine, ten,");


                ThreadContext.clearAll();

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }



    }

}