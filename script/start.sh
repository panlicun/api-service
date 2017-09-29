classpath="classes"
for jarpath in `ls libs/*.jar`
do
        classpath=$classpath:$jarpath
done
java -classpath $classpath cc.homehome.hmblV2.server.HmblServer
