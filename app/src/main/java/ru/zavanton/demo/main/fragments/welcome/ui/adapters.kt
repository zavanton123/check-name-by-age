package ru.zavanton.demo.main.fragments.welcome.ui

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.zavanton.demo.R


@BindingAdapter("latestName")
fun showLatestName(view: View, content: String) {
    val targetView = view as? TextView ?: throw Exception("The view must be TextView")

    targetView.text = if (content.isEmpty()) {
        view.context.resources.getString(R.string.name_not_checked)
    } else {
        view.context.resources.getString(R.string.latest_name, content)
    }
}
