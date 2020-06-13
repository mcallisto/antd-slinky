package slinky.antd3

import slinky.core.{ExternalComponent, TagMod}
import slinky.core.facade.ReactElement

import vision.id.antd.facade.antd.formFormMod.{FormCreateOption, GetFieldDecoratorOptions, WrappedFormUtils}
import vision.id.antd.facade.antd.formFormMod.default.{create => createForm}

import scala.scalajs.js
import scala.scalajs.js.|

object FormFacade {

  /**
    * This is an example of something a bit more complicated than just rewriting component types, and which a manually
    *  written facade. Given an implementation of a component which has a `form` prop which is to be prefilled,
    *  this will generate a ready-to-use `ExternalComponent` for it.
    */
  def formComponent[P <: js.Object](
      options: FormCreateOption[P]
  )(f: js.Function1[P with WithForm, ReactElement]): ExternalComponent {
    type Props = P
  } =
    new ExternalComponent {
      override type Props = P
      override val component: String | js.Object = createForm(options)(f).asInstanceOf[js.Object]
    }

  trait WithForm extends js.Object {
    val form: WrappedFormUtils[js.Object]
  }

  def decoratedField(form: WrappedFormUtils[js.Object], fieldName: String, options: GetFieldDecoratorOptions)(
      children: ReactElement
  ): TagMod[Any] = form.getFieldDecorator(fieldName, options).apply(children)

}
