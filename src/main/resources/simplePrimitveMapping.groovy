import org.nomin.entity.*

mappingFor a: com.github.masterex.models.SourceSimpleObject, b: com.github.masterex.models.TargetSimplePrimitiveObject
a.field1 = b.field1
a.field2 = b.field2
a.field3 = b.field3
a.field5 = b.field5
a.field4 = b.field4
convert to_b: { f -> f as char }