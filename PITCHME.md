#HSLIDE

##Writing Better Java Tests with Spock

[github.com/ssheftel/spock-demo](https://github.com/ssheftel/spock-demo)

#HSLIDE

![spock](https://i.imgflip.com/qnp22.jpg)

#HSLIDE

Spock is a testing and specification framework for Java and Groovy apps

#HSLIDE

Spock is Compatibility
- All IDEs that support jUnit
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
    }
}
```

