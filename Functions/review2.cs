
var name = "Ryan McDermott";

public void PrintAsFirstNameAndLastName()
{
    var temp = name.Split(" ");
    name = $"His first name is {temp[0]}, and his last name is {temp[1]}"; 
    Console.WriteLine(name);
}