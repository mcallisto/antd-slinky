package demo.antd4

import org.scalajs.dom.document
import slinky.core.facade.{React, ReactElement}
import slinky.web.ReactDOM
import org.scalatest.funsuite.AnyFunSuite
import vision.id.antd4.facade.antd.components._

class AntdComponentTest extends AnyFunSuite {
  test("Can render a Tag component") {
    val container = document.createElement("div")
    val aTag = Tag("A tag")
    ReactDOM.render(aTag, container)

    assert(container.innerHTML.contains("A tag") === true)
  }

}
