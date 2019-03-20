# Sample Orika Implementation 
Orika Helps to establish mapping between objects, and tells how it should be constructed.
once you define the mapping in most cases it is 2 way mapping.

we dont need to inject every other mapping service to our Spring service, 
instead just inject `MapperFacade`, it hold all the mapping definition you have defined. 

#### Field to Field mapping
you need to Implement the interface `ObjectMapping` and you can define the field mapping
have a look at `RequestDtoAndResponseDtoMapping` 

#### Spring Service integration
in many case we need to call service to bring more information to populate the object.
as Orika Mapping can be a Spring Bean object we can inject Spring bean into our mapping class

Here i have implemented `CustomMapper` in `VehicleDtoAndRequestDtoCustomMapper` to define mapping.
and pass it to `RequestDtoAndResponseDtoMapping` as custom mapping.

#### Custom Mapper
we ned to be very careful when you are registering CustomMapper on `MapperFactory`
as it overrides other mapping that you have by `ClassMapBuilder`.
it seems `MapperFacade` hold mapping in map against the key of Source and Target,
when you register `CustomMapper` it overrides the old implementation (Not Sure).

#### Filters
you can use Filter to hide data, like `password` or `Credit Card information`
basically to manipulate the data, i am not a big fan of this so removed the possibility of having it for now.

#### Converter
you can define converter like how to convert `LocalDateTime` to `Calender`
here i have one example of `BiDirectionConverter` which take cares of Converting 
`java.util.Optional` to Object and vice versa, have a look at `OptionalConverter`

you can define Converter on field level also check the possibilities while using `ClassMapBuilder`
keep in mind such converter should not be registered with `MapperFactory`

#### Performance 
Issue have documented when Object graph has cycles (Parent references in child object), there are ways to handle this.
also not recommended to have multiple `MapperFacade` object.
 
#### Reference
[Sample TestCases](https://github.com/orika-mapper/orika/tree/master/tests/src/main/java/ma/glasnost/orika/test)