import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Runner
{
    public static void main(String[] args)
    {
        double[] values = { 4.5, 3.5, 2.3, 3.4, 2.2 };
        double significance = 0.05;
        double ci = confidenceInterval(values, significance);

        System.out.println(ci);
    }

    private static double confidenceInterval(double[] values, double significance)
    {
        DescriptiveStatistics statistics = new DescriptiveStatistics(values);
        TDistribution tDist = new TDistribution(statistics.getN() - 1);
        double a = tDist.inverseCumulativeProbability(1.0 - significance / 2);
        return a * statistics.getStandardDeviation() / Math.sqrt(statistics.getN());
    }
}
