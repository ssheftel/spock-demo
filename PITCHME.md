#HSLIDE

##Writing Better Java Tests with Spock

[github.com/ssheftel/spock-demo](https://github.com/ssheftel/spock-demo)

#HSLIDE

![spock](https://i.imgflip.com/qnp22.jpg)

#HSLIDE

Spock is a testing and specification framework for Java and Groovy apps

#HSLIDE

Compatibility
- All existing JUnit tools - it uses JUnit runner 
- SonarQube
- Spring

#HSLIDE

> What makes it stand out from the crowd is its beautiful and highly expressive specification language.

#HSLIDE

##Syntax

#VSLIDE

```groovy
//HashMapSpec.groovy

import spock.lang.Specification

class HashMapSpec extends Specification {
    
    def "HashMap accepts null key"() {
      given: "a hashmap"
        def map = [:]
    
      when: "item is inserted with null as key"
        map.put(null, "elem")
    
      then: "NullPointerException isn't thrown"
        notThrown NullPointerException
        map[null] == "elem"
    }
}

```

#HSLIDE



##Why use Spock?

#VSLIDE

##Test structure

spock enforces setup-trigger-assert paradigm

#VSLIDE

###Spock blocks → clearly marks phases

- `given`: Creates initial conditions
- `setup`: An alternative name for given:
- `when`: Triggers the action that will be tested
- `then`: Examines results of test
- `and`: Cleaner expression of other blocks
- `expect`: Simpler version of then:
- `where`: Parameterized tests
- `cleanup`: Releases resources

#VSLIDE

##Readability

- Spock tests read like sentences
- Unit tests are specifications

> Any fool can write code that a computer can understand. Good programmers write code that humans can understand. - Kent Beck

#VSLIDE

```groovy
def "Client should have a bonus if he spends more than 100 dollars"() {
    when: "a client buys something with value at least 100"
        def client = new Client()
        def billing = new CreditCardBilling()
        billing.charge(client,150)

    then: "Client should have the bonus option active"
        client.hasBonus() == true
}
```

#VSLIDE

##Better Error Messages

![](https://solidsoft.files.wordpress.com/2016/11/spock-formatting-input-parameters-test-specified-error-message.png)

#VSLIDE

##Native Mocking Support

- JUnit needs Mockito
- Mockito does not support partial matchers

```java
when(mock.someMethod(any(), 10)).thenReturn(20);
```

<div style="text-align:center">VS</div>

```groovy
mock.someMethod(_, 10) >> 20
```

#VSLIDE

##Less Boilerplate

Groovy is less verbose and more expressive

```groovy
[] // new ArrayList
[:] // new HashMap
obj.name // obj.getName()
new User(name: "spock") // construct and set values
{n -> x % 2 == 0} // closure
(0..9) // range operator
```

#VSLIDE

##Parameterized tests

```groovy
class ImageNameValidatorSpec extends Specification{

    def "Valid images are PNG and JPEG files"() {
        given: "an image extension checker"
            ImageNameValidator validator = new ImageNameValidator()

        expect: "that only valid filenames are accepted"
            validator.isValidImageExtension(pictureFile) == validPicture

        where: "sample image names are"
            pictureFile        || validPicture
            "scenery.jpg"      || true
            "house.jpeg"       || true
            "car.png"          || true
            "sky.tiff"         || false
            "dance_bunny.gif"  || false
    }
}
```

#HSLIDE

Demo + Examples



