package com.eventapp.ml;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToNominal;

import java.util.Random;

public class EventTypeClassifier {
    public static void main(String[] args) {
        try {
            // Load the dataset
            String datasetPath = "src/main/resources/events.arff";  // relative path
            DataSource source = new DataSource(datasetPath);
            Instances dataset = source.getDataSet();

            // Convert string attributes to nominal
            StringToNominal filter = new StringToNominal();
            filter.setAttributeRange("first-last");
            filter.setInputFormat(dataset);
            dataset = Filter.useFilter(dataset, filter);

            // Set class attribute to last
            dataset.setClassIndex(dataset.numAttributes() - 1);

            // Train J48 model
            J48 tree = new J48();
            tree.buildClassifier(dataset);

            // Evaluate
            Evaluation eval = new Evaluation(dataset);
            eval.crossValidateModel(tree, dataset, 10, new Random(1));

            System.out.println("===== Evaluation Summary =====");
            System.out.println(eval.toSummaryString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
