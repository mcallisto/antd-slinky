package demo.antd

import org.scalajs.dom.document
import slinky.core.facade.{React, ReactElement}
import slinky.web.ReactDOM
import org.scalatest.funsuite.AnyFunSuite
import vision.id.antd.facade.antd.components._

class AntdComponentTest extends AnyFunSuite {
  test("Can render a Tag component") {
    val container = document.createElement("div")
    val aTag = Tag("A tag")
    ReactDOM.render(aTag.asInstanceOf[ReactElement], container)

    assert(container.innerHTML.contains("A tag") === true)
  }

}
