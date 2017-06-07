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

## class SimpleMovingAverage_Bearing
Calculates a simple moving average of compass bearings - based upon a maximum number of items in the simple moving average window.

Wraparound of circular data is dealt with using the method described by darron on stack overflow:
https://stackoverflow.com/questions/491738/how-do-you-calculate-the-average-of-a-set-of-circular-data

```java
import averager.SimpleMovingAverage_Bearing;

...

long length = 10;
SimpleMovingAverage_Bearing smab = new SimpleMovingAverage_Bearing(length);

double value = 355;
double newAverage = smab.addItem(value);
```

## class SimpleMovingAverage_BearingTime
Calculates a simple moving average of compass bearings - based upon a time window.

```java
import averager.SimpleMovingAverage_BearingTime;

...

long keepTimeUnits = 100;
SimpleMovingAverage_BearingTime smabt = new SimpleMovingAverage_BearingTime(keepTimeUnits);

double value = 355;
long currentTimeUnits = 5000;
double newAverage = smabt.addItem(value, currentTimeUnits); // Average is 355
double newAverage = smabt.addItem(5, 5050);                 // Average is 0
double newAverage = smabt.addItem(8, 5120);                 // Average is 6.5
double newAverage = smabt.addItem(2, 5300);                 // Average is 2
```

# Demo
A console app called AveragerDemo is included to demonstrate how it works.