public Path TravelToTexas(object vehicle)
{
    Path path =null;

    if (vehicle.GetType() == typeof(Bicycle))
    {
        path =(vehicle as Bicycle).PeddleTo(new Location("texas"));
    }
    else if (vehicle.GetType() == typeof(Car))
    {
        path=(vehicle as Car).DriveTo(new Location("texas"));
    }


    return path;
}