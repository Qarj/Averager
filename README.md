# Averager 

## class SimpleMovingAverage_Length
Calculates a simple moving average - based on a maximum number of items in the simple moving average window.

```java
import averager.SimpleMovingAverage_Length;

...

long length = 10;
SimpleMovingAverage_Length smal = new SimpleMovingAverage_Length(length);

double value = 5.5;
double newAverage = smal.addItem(value);
```

## class SimpleMovingAverage_Time
Calculates a simple moving average - based on the age of the samples, samples older than the time window are dropped out.

```java
import averager.SimpleMovingAverage_Time;

...

long keepTimeUnits = 100;
SimpleMovingAverage_Time smat = new SimpleMovingAverage_Time(keepTimeUnits);

double value = 5.5;
long currentTimeUnits = 5000;
double newAverage = smat.addItem(value, currentTimeUnits);
```

A console app called AveragerDemo is included to demonstrate how it works.