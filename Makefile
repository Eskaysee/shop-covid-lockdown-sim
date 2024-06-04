compile:
	javac -d bin src/socialDistanceShopSampleSolution/*.java

run:
	java -cp ./bin socialDistanceShopSampleSolution.SocialDistancingShop $(filter-out $@,$(MAKECMDGOALS))

docs:
	javadoc -d doc src/socialDistanceShopSampleSolution/*Grid.java src/socialDistanceShopSampleSolution/Grid*.java src/socialDistanceShopSampleSolution/PeopleCounter.java

clean:
	rm -r bin/socialDistanceShopSampleSolution

cleandocs:
	rm -r doc; mkdir doc