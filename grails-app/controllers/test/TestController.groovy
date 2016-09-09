package test

import grails.gorm.multitenancy.Tenants

class TestController {

    static scaffold = Test

    def test() {
        Tenants.withCurrent {
            Test.withTransaction {
                Test test = new Test(name: UUID.randomUUID().toString())
                test.save()
            }
        }
        Global.withTransaction {

            Global knownGlobal = Global.findByName("imaglobal")
            if(knownGlobal) {
                knownGlobal.foo = knownGlobal.foo + 1
            }
            else {
                knownGlobal = new Global(name: "imaglobal")
            }
            knownGlobal.save()

            Global global = new Global(name: UUID.randomUUID().toString())
            global.save()
        }
    }
}
