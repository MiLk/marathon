package mesosphere.marathon

import org.apache.mesos.{Protos => mesos}
import com.google.protobuf.ByteString
import scala.collection.JavaConverters._


case class ContainerInfo(image: String = "", options: Seq[String] = Seq()) {
  def toProto: mesos.CommandInfo.ContainerInfo =
    mesos.CommandInfo.ContainerInfo.newBuilder()
      .setImage(image)
      .addAllOptions(options.asJava)
      .build()
}

object ContainerInfo {
  def apply(proto: mesos.CommandInfo.ContainerInfo): ContainerInfo =
    ContainerInfo(proto.getImage, proto.getOptionsList.asScala.toSeq)
}
