import Head from "next/head";
import Link from "next/link";
import { SyntheticEvent, useState } from "react";
import { useRouter } from "next/router";

export default function CreateArticle() {
    const router = useRouter()
    const [title, setTitle] = useState("")
    const [author, setAuthor] = useState("")
    const [content, setContent] = useState("")
    const [isMutating, setIsMutating] = useState(false)

    async function handleSubmit(e: SyntheticEvent) {
        e.preventDefault()
        setIsMutating(true)

        await fetch("http://localhost:8080/api/v1/article/create-post", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: title,
                author: author,
                content: content
            })
        })

        console.log(
            JSON.stringify({
                title: title,
                author: author,
                content: content
            })
        )

        setIsMutating(false)
        await router.push("/articles")
    }

    return (
        <div className="p-10 justify-center">
            <Head>
                <title>Create Article</title>
            </Head>
            <div>
                <div className="prose lg:prose-xl py-2 mb-5">
                    <h1>Create Article</h1>
                </div>
                <div className="container glass xl:rounded-box p-10 w-10/12">
                    <div className="card bg-base-100 shadow-xl mx-auto max-w-5xl">
                        <form onSubmit={handleSubmit} className="card-body gap-4 items-end">
                            <div className="form-control w-full">
                                <label className="label">
                                    <span className="label-text font-bold">Title</span>
                                </label>
                                <input
                                    type="text"
                                    value={title}
                                    onChange={(e) => setTitle(e.target.value)}
                                    className="input input-bordered w-full"
                                    placeholder="Type here"
                                />
                            </div>
                            <div className="form-control w-full">
                                <label className="label">
                                    <span className="label-text font-bold">Author</span>
                                </label>
                                <input
                                    type="text"
                                    value={author}
                                    onChange={(e) => setAuthor(e.target.value)}
                                    className="input input-bordered w-full"
                                    placeholder="Type here"
                                />
                            </div>
                            <div className="form-control w-full">
                                <label className="label">
                                    <span className="label-text font-bold">Content</span>
                                </label>
                                <textarea
                                    value={content}
                                    onChange={(e) => setContent(e.target.value)}
                                    className="textarea textarea-bordered"
                                    placeholder="Type here">
                                </textarea>
                            </div>
                            <div className="card-actions justify-between items-end">
                                <div className="flex gap-3">
                                    <button className="btn btn-error text-white" type="button">
                                        <Link href="/articles">Cancel</Link>
                                    </button>
                                    {!isMutating ? (
                                        <button className="btn btn-primary" type="submit">Post</button>
                                    ) : (
                                        <button className="btn btn-primary loading" type="submit">Posting...</button>
                                    )}
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}